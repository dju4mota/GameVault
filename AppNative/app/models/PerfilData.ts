export default class PerfilData{
    nome!: string;
    foto!: string;

    constructor(nome: string, foto: string){
        this.nome = nome;
        this.foto = foto;
    }
}