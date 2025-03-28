#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.yayasanbaik --module-path aisco.product.yayasanbaik -m aisco.product.yayasanbaik &

wait