// setup/main.ts
import { defineAppSetup } from '@slidev/types'
import FigureWithCaption from '../components/FigureWithCaption.vue'
import VideoWithQuote from '../components/VideoWithQuote.vue'


export default defineAppSetup(({ app }) => {
  app.component('FigureWithCaption', FigureWithCaption)
  app.component('VideoWithQuote', VideoWithQuote)
})
