def call(conf){
  def repo Name = conf ["repoName"]
  def pomFile = readMavenPom file: 'pom.xml'
  def version = pomFile.version
  def artifactId = pomFile.artifactId
  def type = pomFile.groupId
  def groupId = pomFile.groupId
  nexusArtifactUploader artifacts: [[artifactId: '${artifactId}', classifier: '', file: "target/${artifactId}-${version}.war", type: type]], credentialsId: 'nexus3', groupId: groupId, nexusUrl: '172.31.11.119:8081/', nexusVersion: 'nexus3', protocol: 'http', repository: 'my-app-release', version: "${version}"
}
