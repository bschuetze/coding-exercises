<?php

declare(strict_types=1);

const BASE_URL = 'https://api.demo.sitehost.co.nz';
const API_VERSION = '1.0';
const END_POINT = 'list_domains';
const FORMAT = 'json';
const API_KEY = 'd17261d51ff7046b760bd95b4ce781ac';

$clientID = '293785';

$queryString = http_build_query([
    'apikey' => API_KEY,
    'client_id' => $clientID
]);
$requestUri = sprintf(
    '%s/%s/srs/%s.%s?%s',
    BASE_URL,
    API_VERSION,
    END_POINT,
    FORMAT,
    $queryString
);

$fp = fopen($requestUri, 'r');

$responseString = stream_get_contents($fp);

$customerDomains = json_decode($responseString, true);

fclose($fp);

$pageContent = "<!DOCTYPE html>
<html lang='en'>
  <head>
    <meta charset='utf-8'>
    <title>Domains For {$clientID}</title>
  </head>
  <body>
";

foreach ($customerDomains['return']['data'] as $value) {
    $tmp = $value['domain'];
    $pageContent = $pageContent . "    <a href='{$tmp}'>{$tmp}</a>\n";
}

$pageContent = $pageContent . "
  </body>
</html>";

$outputFile = 'index.html';

file_put_contents($outputFile, $pageContent);

?>