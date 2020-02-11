FROM golang:1.13

RUN (cd "$(mktemp -d)" && go mod init enry && go get github.com/src-d/enry/v2/cmd/enry)

VOLUME [ "/project" ]

WORKDIR /project
ENTRYPOINT [ "enry" ]
