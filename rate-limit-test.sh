#!/bin/bash
#help : https://devdojo.com/mvnarendrareddy/access-windows-localhost-from-wsl2
# Define the API endpoint URL
API_ENDPOINT="http://172.17.160.1:9090/app-converter/currency"

# Number of times to call the API
#NUM_REQUESTS=10
i=0
# Loop to make POST requests
while [ "$i" -le 10 ]; do
  # Make the POST request, capture the response status, and discard the response body
  response=$(curl -s -w "%{http_code}" $API_ENDPOINT)
  #http_code=$(tail -n1 <<< "$response")  # get the last line
  #content=$(sed '$ d' <<< "$response")   # get all but the last line which contains the status code
   i=$(( i + 1 ))
  # Print the response status
  echo "Request $i: Response Status - $response"
done