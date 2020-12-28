DOMAIN=example
APP_NAME=inbox-receivemsg-process
DIR=/$(APP_NAME)/
REMOTE_HOST=mana@10.9.214.101
REGISTRY_PATH=ktbirp81.ktb:5000/paotang/v2/$(APP_NAME):$(tag)
tag=uat
profile=dev

# example 'make run profile=dev'
run:
	./gradlew bootRun --args='--spring.profiles.active=$(profile)'

# example 'make dev'
dev:
	./gradlew bootRun --args='--spring.profiles.active=dev'

local:
	./gradlew bootRun --args='--spring.profiles.active=local'

uat:
	./gradlew bootRun --args='--spring.profiles.active=uat'

build-jar:
	./gradlew --build-file "build.gradle.kts" clean build -x test

push-image:
	docker build . --no-cache -t $(REGISTRY_PATH)

	docker push $(REGISTRY_PATH)

	yes | docker image prune

apply-k8s:
	scp .k8s/k8s-*.yaml "$(REMOTE_HOST):~/$(DIR)"
	echo "> Copy successful..."

	ssh -T $(REMOTE_HOST) '\
    		cd $(DIR); \
    		kubectl delete -f k8s-configmap.yaml; \
    		kubectl apply -f k8s-configmap.yaml; \
    		kubectl delete -f k8s-deployment.yaml; \
    		kubectl apply -f k8s-deployment.yaml'

deploy:	build-jar	push-image	apply-k8s
