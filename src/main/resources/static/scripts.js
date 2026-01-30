document.addEventListener("DOMContentLoaded", () => {

    const paisSelect = document.getElementById("pais");
    const estadoSelect = document.getElementById("estado");
    const municipioSelect = document.getElementById("municipio");

    paisSelect.addEventListener("change", () => {
        const paisId = paisSelect.value;

        estadoSelect.innerHTML = '<option value="">-- Selecciona un estado --</option>';
        estadoSelect.disabled = true;

        municipioSelect.innerHTML = '<option value="">-- Selecciona un municipio --</option>';
        municipioSelect.disabled = true;

        if (!paisId) return;

        fetch(`/estados/pais/${paisId}`)
            .then(r => r.json())
            .then(estados => {
                estados.forEach(e => {
                    const opt = document.createElement("option");
                    opt.value = e.id;
                    opt.textContent = e.nombre;
                    estadoSelect.appendChild(opt);
                });
                estadoSelect.disabled = false;
            })
            .catch(err => console.error(err));
    });

    estadoSelect.addEventListener("change", () => {
        const estadoId = estadoSelect.value;

        municipioSelect.innerHTML = '<option value="">-- Selecciona un municipio --</option>';
        municipioSelect.disabled = true;

        if (!estadoId) return;

        fetch(`/municipios/estado/${estadoId}`)
            .then(r => r.json())
            .then(municipios => {
                if (!Array.isArray(municipios)) {
                    console.error("Respuesta inesperada:", municipios);
                    return;
                }
                municipios.forEach(m => {
                    const opt = document.createElement("option");
                    opt.value = m.id;
                    opt.textContent = m.nombre;
                    municipioSelect.appendChild(opt);
                });
                municipioSelect.disabled = false;
            })
            .catch(err => console.error(err));
    });
});

