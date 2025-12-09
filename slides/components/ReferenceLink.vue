<template>
  <div class="col-span-2 text-xs text-center text-gray-600 mt-4">
      Fonte:
      <a :href="reference" class="underline text-blue-600" target="_blank">
        {{ reference }}
      </a>
    </div>
</template>
<script setup>
defineProps({
  reference: String
})
</script>