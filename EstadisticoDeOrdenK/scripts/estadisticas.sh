#!/bin/bash

OUT=estadisticas.out


n=$1
ARRAY=""
echo "n = $n" >> $OUT
for((i=0; i < $n; i++)); do
	ARRAY=$ARRAY" "$RANDOM 
done
ARRAY=$(echo $ARRAY | sed -e 's/^[[:space:]]//')

## Para k = minimo
k=0
echo "k = $k" >> $OUT
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar fb $k "$ARRAY"
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar os $k "$ARRAY"
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar ks $k "$ARRAY"
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar kh $k "$ARRAY"
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar hs $k "$ARRAY"
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar qs $k "$ARRAY"

## Para k = mediana
k=$(echo $n/2 | bc )
echo "k = $k" >> $OUT
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar fb $k "$ARRAY"
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar os $k "$ARRAY"
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar ks $k "$ARRAY"
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar kh $k "$ARRAY"
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar hs $k "$ARRAY"
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar qs $k "$ARRAY"


## Para k = maximo
k=$(echo $n-1 | bc )
echo "k = $k" >> $OUT
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar fb $k "$ARRAY"
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar os $k "$ARRAY"
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar ks $k "$ARRAY"
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar kh $k "$ARRAY"
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar hs $k "$ARRAY"
time java -jar target/EstadisticoDeOrdenK-1.0.0.jar qs $k "$ARRAY"

# Para n = 10
# Para n = 50
# Para n = 100
# Para n = 500
# Para n = 1000
# Para n = 5000
# Para n = 100000
