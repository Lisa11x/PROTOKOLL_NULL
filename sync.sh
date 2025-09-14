#!/data/data/com.termux/files/usr/bin/bash
set -e

# SSH-Agent starten
eval $(ssh-agent -s) >/dev/null
ssh-add ~/.ssh/id_ed25519 >/dev/null 2>&1 || true

echo "🔄 Zuerst Pull von GitHub..."
git pull origin main || echo "⚠️ Kein Pull möglich (evtl. keine neuen Änderungen)."

echo "⬆️ Danach Push mit Timestamp..."
git add .
git commit -m "Sync: $(date '+%Y-%m-%d %H:%M:%S')" || echo "⚠️ Keine neuen Commits."
git push origin main || echo "⚠️ Push fehlgeschlagen."
