using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace CatalogoAPI.Migrations
{
    public partial class AddProdutos : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.Sql("INSERT INTO Produtos(Nome,Descricao,Preco,ImagemUrl,Estoque,DataCadastro,CategoriaId)" +
                "VALUES('Coca-cola', 'Refrigerante de Cola 1L', 6.30, 'cocacola.png', 50, now(), 1)");

            migrationBuilder.Sql("INSERT INTO Produtos(Nome,Descricao,Preco,ImagemUrl,Estoque,DataCadastro,CategoriaId)" +
                "VALUES('Sanduiche de Atum', 'Sanduiche de Atum puro', 4.50, 'sandAtum.png', 100, now(), 2)");

            migrationBuilder.Sql("INSERT INTO Produtos(Nome,Descricao,Preco,ImagemUrl,Estoque,DataCadastro,CategoriaId)" +
                "VALUES('Cookie de Chocolate', 'Cookie natural de chocolate', 1.50, 'cookie.png', 30, now(), 3)");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.Sql("Delete from Produtos");
        }
    }
}
