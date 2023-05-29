#!/bin/sh

set -i 

mdbook build
cd docs && rpl -Rx .html '.md"' '.html"' *

