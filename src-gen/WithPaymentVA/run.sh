#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.withpaymentva --module-path aisco.product.withpaymentva -m aisco.product.withpaymentva &

wait