#!/data/data/com.termux/files/usr/bin/bash
set -e

# SSH-Agent starten (falls nicht aktiv)
eval $(ssh-agent -s) >/dev/null
ssh-add ~/.ssh/id_ed25519 >/dev/null 2>&1 || true

# Alle Änderungen aufnehmen
git add .

# Commit mit Timestamp
git commit -m "Update: $(date '+%Y-%m-%d %H:%M:%S')" || echo "⚠️ Keine neuen Änderungen."

# Push nach GitHub
git push origin main
