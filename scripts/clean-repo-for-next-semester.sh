#!/bin/bash

# Diretório base
BASE_DIR=$(pwd)

# 1️⃣ Limpar submissions, mantendo apenas o .gitkeep
echo "🧹 Limpando submissions/ exceto .gitkeep..."
find "${BASE_DIR}/assignments" -type d -name submissions | while read submission_dir; do
  find "$submission_dir" -mindepth 1 -not -name ".gitkeep" -exec rm -rf {} +
done

# 1.2️⃣ Limpar submissions de extras, mantendo apenas o .gitkeep
echo "🧹 Limpando extras/*/submissions (mantendo .gitkeep)..."
find "${BASE_DIR}/extras" -type d -name submissions | while read submission_dir; do
  find "$submission_dir" -mindepth 1 -not -name ".gitkeep" -exec rm -rf {} +
done

# 1.1️⃣ Limpar submissions do classroom, mantendo apenas o .gitkeep
echo "🧹 Limpando classroom/*/submissions (mantendo .gitkeep)..."
find "${BASE_DIR}/classroom" -type d -name submissions | while read submission_dir; do
  find "$submission_dir" -mindepth 1 -not -name ".gitkeep" -exec rm -rf {} +
done

# 2️⃣ Limpar arquivos do diretório readings/
echo "🧹 Limpando arquivos em readings/..."
find "${BASE_DIR}/readings" -type f -name "*.pdf" -exec rm -f {} \;

# 2.1️⃣ Limpar submissions em readings, mantendo apenas o .gitkeep
echo "🧹 Limpando readings/*/submissions (mantendo .gitkeep)..."
find "${BASE_DIR}/readings" -type d -name submissions | while read submission_dir; do
  find "$submission_dir" -mindepth 1 -not -name ".gitkeep" -exec rm -rf {} +
done

echo "🧹 Limpando challenges/*/submissions (mantendo .gitkeep)..."
find "${BASE_DIR}/challenges" -type d -name submissions | while read submission_dir; do
  find "$submission_dir" -mindepth 1 -not -name ".gitkeep" -exec rm -rf {} +
done

echo "✅ Diretórios limpos com sucesso!"
