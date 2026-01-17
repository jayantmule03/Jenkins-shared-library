def call(Map config = [:]) {
    def imageName   = config.imageName ?: error("Image name is required")
    def imageTag    = config.imageTag ?: 'latest'
    def credentials = config.credentials ?: 'docker-hub-credentials'

    steps.echo "Pushing Docker image: ${imageName}:${imageTag}"

    steps.withCredentials([steps.usernamePassword(
        credentialsId: credentials,
        usernameVariable: 'DOCKER_USERNAME',
        passwordVariable: 'DOCKER_PASSWORD'
    )]) {
        steps.sh """
            echo "\$DOCKER_PASSWORD" | docker login -u "\$DOCKER_USERNAME" --password-stdin
            docker push ${imageName}:${imageTag}
            docker push ${imageName}:latest
        """
    }
}

