-- Consulta: Top 10 operadoras com maiores despesas no último TRIMESTRE de 2024
SELECT
    dc.reg_ans,
    oa.nome_fantasia,
    SUM(dc.vl_saldo_final) AS total_despesas
FROM
    demonstracoes_contabeis dc
        JOIN
    operadoras_ativas oa
    ON dc.reg_ans = oa.registro_ans
WHERE
    dc.descricao ILIKE '%SINISTROS CONHECIDOS OU AVISADOS%MEDICO HOSPITALAR%'
    AND dc.data BETWEEN DATE '2024-10-01' AND DATE '2024-12-31'
GROUP BY
    dc.reg_ans, oa.nome_fantasia
ORDER BY
    total_despesas DESC
    LIMIT 10;


-- Consulta: Top 10 operadoras com maiores despesas no ANO de 2024
SELECT
    dc.reg_ans,
    oa.nome_fantasia,
    SUM(dc.vl_saldo_final) AS total_despesas
FROM
    demonstracoes_contabeis dc
        JOIN
    operadoras_ativas oa
    ON dc.reg_ans = oa.registro_ans
WHERE
    dc.descricao ILIKE '%SINISTROS CONHECIDOS OU AVISADOS%MEDICO HOSPITALAR%'
    AND dc.data BETWEEN DATE '2024-01-01' AND DATE '2024-12-31'
GROUP BY
    dc.reg_ans, oa.nome_fantasia
ORDER BY
    total_despesas DESC
    LIMIT 10;
