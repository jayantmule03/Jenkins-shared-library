def call() {
    steps.dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'OWASP'
    steps.dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}

