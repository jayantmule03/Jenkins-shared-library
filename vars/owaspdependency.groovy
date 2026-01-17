def call() {
    steps.dependencyCheck(
        additionalArguments: '''
          --scan .
          --format XML
          --out dependency-check-report
        ''',
        odcInstallation: 'OWASP'
    )

    steps.dependencyCheckPublisher pattern: '**/dependency-check-report/dependency-check-report.xml'
}


