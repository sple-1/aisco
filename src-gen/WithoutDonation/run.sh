#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.withoutdonation --module-path aisco.product.withoutdonation -m aisco.product.withoutdonation &

wait