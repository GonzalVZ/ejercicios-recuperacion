#!/bin/bash

# ===============================
# MEGA SCRIPT DE GIT + GITHUB SSH
# Uso seguro en PC compartido
# ===============================

clear
echo "🛠️  BIENVENIDO AL MEGA SCRIPT DE GIT + GITHUB"
echo ""
echo "¿Qué deseas hacer?"
echo "1. Configurar Git + generar clave SSH (PC nuevo, sin proyecto)"
echo "2. Iniciar un nuevo proyecto Git y subirlo a GitHub"
echo "3. Subir cambios a un repositorio ya clonado"
echo "4. Limpiar configuración y eliminar clave SSH (salida del ordenador)"
read -p "Selecciona una opción (1-4): " opcion

case $opcion in
  1)
    echo "=== CONFIGURANDO GIT + SSH ==="
    read -p "Tu nombre (para Git): " nombre
    read -p "Tu correo (para Git y GitHub): " email
    git config --global user.name "$nombre"
    git config --global user.email "$email"

    if [ -f ~/.ssh/id_ed25519 ]; then
      echo "🔐 Ya existe una clave SSH en ~/.ssh/id_ed25519"
    else
      echo "🛠 Generando clave SSH protegida con contraseña..."
      ssh-keygen -t ed25519 -C "$email"
    fi

    echo ""
    echo "📋 Copia esta clave pública en GitHub (Settings > SSH and GPG keys > New SSH key):"
    cat ~/.ssh/id_ed25519.pub
    echo ""
    read -p "Presiona Enter cuando la hayas pegado..."
    echo "✅ Git y SSH configurados. Puedes usar GitHub vía SSH."
    ;;

  2)
    echo "=== INICIALIZANDO Y SUBIENDO PROYECTO ==="
    echo "📁 Carpeta actual: $(pwd)"
    read -p "¿Es esta tu carpeta de proyecto? (Enter para continuar o Ctrl+C para cancelar)"
    git init
    read -p "Introduce la URL SSH del repositorio (ej: git@github.com:usuario/repo.git): " url
    git remote add origin "$url"
    git add .
    git commit -m "Primer commit"
    git pull --rebase origin main 2>/dev/null
    git push -u origin main
    echo "✅ Proyecto subido correctamente."
    ;;

  3)
    echo "=== SUBIENDO CAMBIOS AL REPO YA CLONADO ==="
    git add .
    read -p "Mensaje del commit: " mensaje
    git commit -m "$mensaje"
    git push
    echo "✅ Cambios subidos."
    ;;

  4)
    echo "=== LIMPIANDO CONFIGURACIÓN ==="
    echo "🔐 Eliminando clave SSH..."
    rm -f ~/.ssh/id_ed25519 ~/.ssh/id_ed25519.pub
    echo "🧹 Borrando configuración de Git..."
    git config --global --unset user.name
    git config --global --unset user.email
    rm -f ~/.gitconfig
    echo "🧽 Elimina manualmente credenciales HTTPS si usaste alguna (Administrador de credenciales de Windows)."
    echo "✅ Sistema limpio."
    ;;

  *)
    echo "❌ Opción no válida. Ejecuta el script de nuevo y elige una opción entre 1 y 4."
    ;;
esac
