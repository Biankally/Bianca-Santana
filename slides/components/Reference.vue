<template>
    <div class="mt-4 text-xs text-center text-gray-600">
        Fonte: {{ reference }}
    </div>
</template>
<script setup>
defineProps({
  reference: String
})
</script>