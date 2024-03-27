sbtVersion := "1.9.9"

setup:
  scala-cli setup-ide .

run:
  scala-cli run .

serveViz:
  ./cs launch io.github.quafadas:dedav4s_3:0.9.0 -M viz.websockets.serve -- 8085

startVizServer:
  echo starting server at http://localhost:8085
  ./cs launch io.github.quafadas:dedav4s_3:0.9.0 -M viz.websockets.serve -- 8085

installCoursier:
  curl -fL "https://github.com/coursier/launchers/raw/master/cs-x86_64-pc-linux.gz" | gzip -d > cs
  chmod +x cs
  
installJust:
  wget -qO - 'https://proget.makedeb.org/debian-feeds/prebuilt-mpr.pub' | gpg --dearmor | sudo tee /usr/share/keyrings/prebuilt-mpr-archive-keyring.gpg 1> /dev/null
  echo "deb [arch=all,$(dpkg --print-architecture) signed-by=/usr/share/keyrings/prebuilt-mpr-archive-keyring.gpg] https://proget.makedeb.org prebuilt-mpr $(lsb_release -cs)" | sudo tee /etc/apt/sources.list.d/prebuilt-mpr.list
  sudo apt update
  sudo apt install just
