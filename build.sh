#!/bin/sh

set -i

mdbook build
cd book && rpl -Rx .html '.md"' '.html"' *

