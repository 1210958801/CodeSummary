<template v-if="ok">
  <div>
    <select v-model="selected">
      <option v-for="option in options" v-bind:value="option.value"/>
        {{ option.text }}
      </option>
    </select>
    <span>Selected: {{ selected }}</span>
  </div>
</template>

<script>
  export default {
    data: {
      selected: 'A',
      options: [{
          text: 'One',
          value: 'A'
        },
        {
          text: 'Two',
          value: 'B'
        },
        {
          text: 'Three',
          value: 'C'
        }
      ]
    }
  }
</script>
<style>
</style>
