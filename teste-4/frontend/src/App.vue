<template>
  <div>
    <h2>Buscar Operadora ANS</h2>
    <input v-model="busca" placeholder="Digite um nome" />
    <button @click="buscar">Buscar</button>

    <ul>
      <li v-for="op in resultados" :key="op.Codigo_ANS">
        {{ op.Razao_Social }} - Nº Registro: {{ op.Registro_ANS }}
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'

const busca = ref('')
const resultados = ref([])

const buscar = async () => {
  try {
    const res = await axios.get(`http://localhost:8000/buscar?query=${busca.value}`)
    resultados.value = res.data
  } catch (error) {
    console.error("Erro ao buscar:", error)
  }
}
</script>

