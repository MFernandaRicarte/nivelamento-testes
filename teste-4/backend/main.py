from fastapi import FastAPI, Query
import pandas as pd
from fastapi.middleware.cors import CORSMiddleware

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_methods=["*"],
    allow_headers=["*"],
)

df = pd.read_csv("operadoras_ativas.csv", sep=";", encoding="latin1")

@app.get("/buscar")
def buscar_operadora(query: str = Query(..., min_length=2)):
    resultados = df[df['Razao_Social'].str.contains(query, case=False, na=False)]
    return resultados.head(20).fillna("").replace([float("inf"), float("-inf")], "").to_dict(orient="records")

