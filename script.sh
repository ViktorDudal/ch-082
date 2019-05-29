#!/bin/sh

status_code=$(curl --write-out %{http_code} --silent --output /dev/null localhost:8080/RabotyNET/vacancies)

if [[ "$status_code" -ne 200 ]] ; then
    echo "Site status changed to $status_code"
    exit 1
else
    echo "Site status changed to $status_code"
    exit -1
fi
