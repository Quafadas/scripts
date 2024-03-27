

setup:
  scala-cli setup-ide .

run:
  scala-cli run .

startVizServer:
  echo starting server at http://localhost:8085
  cs launch io.github.quafadas:dedav4s_3:0.9.0 -M viz.websockets.serve -- 8085