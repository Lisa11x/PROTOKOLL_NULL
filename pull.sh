#!/data/data/com.termux/files/usr/bin/bash
set -e

# SSH-Agent starten
eval $(ssh-agent -s) >/dev/null
ssh-add ~/.ssh/id_ed25519 >/dev/null 2>&1 || true

# Pull von GitHub
git pull origin main
