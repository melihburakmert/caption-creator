# Caption Creator

A microservice based application that allows users to create caption for an image, \
based on their recently played song lyrics. \

Done completely for fun and practice.

## Services

- api-gateway-service
- playback-data-service
- lyrics-service
- genai-service

## Infrastructure

- docker

## How to run

1. Clone the repository
2. Build all the images with mvn jib:dockerBuild
3. Run the docker-compose file with `docker-compose up`

### TODO:
- [ ] Add frontend
- [ ] Add kubernetes deployment
- [ ] Add CI/CD pipeline
- [ ] Add more services