#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.coralschool --module-path aisco.product.coralschool -m aisco.product.coralschool &

wait