{api_server}/{api_version}/{method}.{format}?{args}&apikey={api_key}

so

https://api.demo.sitehost.co.nz/1.0/

customer #293785 

https://api.demo.sitehost.co.nz/1.0/srs/list_domains.json?apikey=d17261d51ff7046b760bd95b4ce781ac

https://api.demo.sitehost.co.nz/1.0/srs/list_domains.json?apikey=d17261d51ff7046b760bd95b4ce781ac

https://api.demo.sitehost.co.nz/1.0/srs/list_domains.json?client_id=293785&apikey=d17261d51ff7046b760bd95b4ce781ac


require_once('vendor/autoload.php');

$dotenv = Dotenv\Dotenv::createImmutable(__DIR__);
$dotenv->load();