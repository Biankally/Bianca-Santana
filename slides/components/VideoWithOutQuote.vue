<template>
  <div class="gap-6 items-center">
    <!-- Vídeo do YouTube -->
    <div class="w-full flex flex-col items-center justify-center text-center mt-4">
      <Youtube :id="videoId" width="100%" height="300" />
    </div>

    <!-- Fonte -->
    <div class="col-span-2 text-xs text-center text-gray-600 mt-4">
      Fonte:
      <a :href="sourceUrl" class="underline text-blue-600" target="_blank">
        {{ sourceUrl }}
      </a>
    </div>
  </div>
</template>

<script setup>
defineProps({
  videoId: String,
  quote: String,
  author: String,
  sourceUrl: String
})
</script>
