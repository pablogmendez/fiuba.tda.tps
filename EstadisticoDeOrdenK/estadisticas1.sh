#!/bin/bash
rm estadisticas.out
./estadisticas.sh 5 2>estadisticas.err
cat estadisticas.err | grep user >> estadisticas.out
./estadisticas.sh 10 2>estadisticas.err
cat estadisticas.err | grep user >> estadisticas.out
./estadisticas.sh 50 2>estadisticas.err
cat estadisticas.err | grep user >> estadisticas.out
./estadisticas.sh 100 2>estadisticas.err
cat estadisticas.err | grep user >> estadisticas.out
./estadisticas.sh 500 2>estadisticas.err
cat estadisticas.err | grep user >> estadisticas.out
./estadisticas.sh 1000 2>estadisticas.err
cat estadisticas.err | grep user >> estadisticas.out
./estadisticas.sh 5000 2>estadisticas.err
cat estadisticas.err | grep user >> estadisticas.out
./estadisticas.sh 10000 2>estadisticas.err
cat estadisticas.err | grep user >> estadisticas.out
./estadisticas.sh 50000 2>estadisticas.err
cat estadisticas.err | grep user >> estadisticas.out
./estadisticas.sh 100000 2>estadisticas.err
cat estadisticas.err | grep user >> estadisticas.out
