#!/bin/bash

echo "=== CONFIGURANDO GIT + SSH ==="

# Verificar que git y ssh-keygen están instalados
if ! command -v git &> /dev/null; then
  echo "❌ Git no está instalado. Instálalo antes de continuar."
  exit 1
fi

if ! command -v ssh-keygen &> /dev/null; then
  echo "❌ ssh-keygen no está instalado. Instálalo antes de continuar."
  exit 1
fi

# Solicitar nombre y correo, y verificar que no estén vacíos
read -p "Tu nombre (para Git): " nombre
read -p "Tu correo (para Git y GitHub): " email

if [ -z "$nombre" ] || [ -z "$email" ]; then
  echo "❌ El nombre y el correo no pueden estar vacíos."
  exit 1
fi

# Configurar Git globalmente
git config --global user.name "$nombre"
git config --global user.email "$email"

# Crear carpeta ~/.ssh si no existe
mkdir -p ~/.ssh
chmod 700 ~/.ssh

# Generar o conservar clave SSH
CLAVE=~/.ssh/id_ed25519
if [ -f "$CLAVE" ]; then
  echo "🔐 Ya existe una clave SSH en $CLAVE"
  read -p "¿Deseas sobrescribirla? (s/n): " resp
  if [[ "$resp" == "s" || "$resp" == "S" ]]; then
    ssh-keygen -t ed25519 -C "$email" -f "$CLAVE"
  fi
else
  echo "🛠 Generando clave SSH protegida con contraseña..."
  ssh-keygen -t ed25519 -C "$email" -f "$CLAVE"
fi

# Asegurar permisos correctos
chmod 600 "$CLAVE"
chmod 644 "$CLAVE.pub"

# Mostrar la clave pública y pedir que se añada a GitHub
echo ""
echo "📋 Copia esta clave pública en GitHub:"
echo "👉 https://github.com/settings/ssh/new"
echo ""
cat "$CLAVE.pub"
echo ""
read -p "Presiona Enter cuando la hayas pegado en GitHub..."

echo "✅ Git y SSH configurados correctamente. Puedes usar GitHub vía SSH."
