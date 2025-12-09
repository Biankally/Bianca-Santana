<!-- components/FigureWithCaption.vue -->
<template>
  <figure class="w-full flex flex-col items-center justify-center text-center mt-4">
    <img 
      :src="computedSrc"
      :alt="alt"
      class="max-h-[270px] rounded shadow mb-2"
    />
    <figcaption class="mt-2 text-xs text-center text-gray-600">
      Fonte: 
      <a :href="link" target="_blank" class="underline text-blue-600">
        {{ link }}
      </a>
      <div>{{ reference }}</div>
    </figcaption>
  </figure>
</template>

<script setup>

import { computed } from 'vue'

const props = defineProps({
  src: String,
  alt: String,
  link: String,
  reference: String
})

const baseURL = import.meta.env.BASE_URL

const computedSrc = computed(() => {
  if (/^(https?:)?\/\//.test(props.src)) {
    return props.src // URL externa
  }

  if (props.src.startsWith('/')) {
    return "/" + props.src // já começa da raiz
  }

  // imagem local relativa no public/
  return props.src
})

console.log(baseURL)
console.log(props.src)

</script>
