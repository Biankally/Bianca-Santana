<template>
  <div class="slidev-layout default w-full h-full relative bg-white text-gray-800">
    <!-- Header azul -->
    <header class="absolute top-0 left-0 right-0 h-12 px-6 py-2 flex justify-between items-center text-sm bg-[#002f53] text-gray-200 z-10 shadow-md">
      <div>{{ $slidev.configs.lesson || 'Programação Orientada a Objetos com Java' }}</div>
      <div>Página {{ $slidev.nav.currentPage }}/{{ $slidev.nav.total }}</div>
    </header>

    <!-- Conteúdo do slide -->
    <div class="pt-10 pb-10 px-10 h-full">
      <slot />
    </div>

    <!-- Rodapé -->
    <footer class="absolute bg-[#002f53] bottom-0 left-0 right-0 h-10 px-6 py-1 flex justify-between items-center text-xs text-gray-400 border-t border-gray-200 z-10">
      <div class="absolute bottom-0 left-0 h-1 w-full bg-gray-400 z-20">
        <div class="h-full bg-[#a68acb] transition-all duration-300" :style="{ width: `${($slidev.nav.currentPage / $slidev.nav.total) * 100}%` }"/>
      </div>
      <div>Ciência da Computação - IDP</div>
      <div>Programação Orientada a Objetos com Java</div>      
      <div>2025.2</div>
      <div>Prof. Fabricio Santana</div>
    </footer>
  </div>
</template>
