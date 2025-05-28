#!/bin/bash

# =============================
# CONFIGURACIÓN DE GIT + SSH
# USO PERSONAL EN PC COMPARTIDO
# =============================

echo "=== Configuración rápida de Git con SSH protegido ==="

# Mostrar carpeta actual (por seguridad)
echo "📁 Carpeta actual: $(pwd)"
read -p "¿Esta es tu carpeta del proyecto? (Enter para continuar o Ctrl+C para cancelar)"

# Configurar Git solo para este proyecto (no global)
read -p "Tu nombre (para Git): " nombre
read -p "Tu correo (para Git y GitHub): " email
git config user.name "$nombre"
git config user.email "$email"

# Verificar si la clave SSH ya existe
if [ -f ~/.ssh/id_ed25519 ]; then
  echo "🔐 Ya tienes una clave SSH. Asegúrate de que esté protegida con contraseña."
else
  echo "🛠 No se encontró clave SSH. Vamos a generar una."
  echo "📌 IMPORTANTE: Usa una contraseña cuando te la pida. No la dejes en blanco."
  ssh-keygen -t ed25519 -C "$email"
fi

# Mostrar la clave pública para pegar en GitHub
echo ""
echo "📋 Copia esta clave pública en tu cuenta de GitHub (Settings > SSH and GPG keys > New SSH key):"
cat ~/.ssh/id_ed25519.pub
echo ""
read -p "Presiona Enter cuando ya la hayas añadido..."

# Enlazar el repositorio remoto (por SSH)
read -p "URL del repositorio SSH (ej: git@github.com:usuario/repositorio.git): " url
git init
git remote add origin "$url"

# Añadir, hacer commit y subir
git add .
git commit -m "Primer commit"
git pull --rebase origin main 2>/dev/null
git push -u origin main

echo ""
echo "✅ Código subido de forma segura."

# 🔒 IMPORTANTE: este script NO carga la clave en memoria (no usa ssh-add),
# por lo tanto, NADIE puede usar tu clave sin tu contraseña.
# Es seguro dejar este script dentro del proyecto, incluso en un PC compartido.

