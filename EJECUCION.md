# Nequi

## Ejecución

### Software necesario

* Insomnia / Postman

## Franquicias

#### Crear
```
curl --request POST \
  --url http://localhost:8080/franchise/api/v1/franchise \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/10.3.1' \
  --data '{
	"name":"Frisby"
}'
```

#### Listar
```
curl --request GET \
  --url http://localhost:8080/franchise/api/v1/franchise \
  --header 'User-Agent: insomnia/10.3.1'
```

#### Listar por Id
```
curl --request GET \
  --url http://localhost:8080/franchise/api/v1/franchise/1 \
  --header 'User-Agent: insomnia/10.3.1'
```

## Sucursales

#### Crear
```
curl --request POST \
  --url http://localhost:8080/franchise/api/v1/branch \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/10.3.1' \
  --data '{
	"name":"Salitre Plaza",
	"idFranchise": 4
}'
```

#### Listar
```
curl --request GET \
  --url http://localhost:8080/franchise/api/v1/branch \
  --header 'User-Agent: insomnia/10.3.1'
```
#### Listar por Id
```
curl --request GET \
--url http://localhost:8080/franchise/api/v1/branch/1 \
--header 'User-Agent: insomnia/10.3.1'
```

## Productos

#### Crear
```
curl --request POST \
  --url http://localhost:8080/franchise/api/v1/product \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/10.3.1' \
  --data '{
	"name":"Combo infantil",
	"stock": 40,
	"idBranch": 3
}'
```

#### Listar
```
curl --request GET \
  --url http://localhost:8080/franchise/api/v1/product \
  --header 'User-Agent: insomnia/10.3.1'
```
#### Listar por Id
```
curl --request GET \
  --url http://localhost:8080/franchise/api/v1/product/1 \
  --header 'User-Agent: insomnia/10.3.1'
```
#### Eliminar
```
curl --request DELETE \
  --url http://localhost:8080/franchise/api/v1/product/4 \
  --header 'User-Agent: insomnia/10.3.1'
```
#### Listar productos con mayor stock por sucursal para una franquicia
```
curl --request GET \
  --url http://localhost:8080/franchise/api/v1/product/find-max-stock-by-id-franchise/4 \
  --header 'User-Agent: insomnia/10.3.1'
```