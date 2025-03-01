# Caption Creator

-- Work in progress --

A microservice based application that allows users to create caption for an image, \
based on their recently played song lyrics.

Done completely for fun and practice.

Most things depend on Google Cloud Platform,\
so you need to have a GCP account to run things.

## Services

- api-gateway-service
- playback-data-service
- lyrics-service
- genai-service

## Infrastructure

- docker

## How to run

1. Clone the repository
2. Set up the environment variables for GCR and external api keys
3. Build all the images with mvn jib:dockerBuild
4. Run the docker-compose file with `docker-compose up`

### TODO:
- [ ] Add frontend
- [ ] Add kubernetes deployment
- [ ] Add CI/CD pipeline
- [ ] Add more services