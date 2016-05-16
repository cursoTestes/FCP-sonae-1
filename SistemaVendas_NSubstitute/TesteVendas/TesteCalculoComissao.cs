using Microsoft.VisualStudio.TestTools.UnitTesting;
using SistemaVendas;

namespace TesteVendas
{
    [TestClass]
    public class TesteCalculoComissao
    {
        [TestMethod]
        public void Teste_ValorVendas_igual_10000()
        {
            decimal valorVenda = 10000;
            decimal valorEsperado = 500;

            CalculadoraComissao calculadora = new CalculadoraComissao();

            decimal retorno = calculadora.calcular(valorVenda);

            Assert.AreEqual(valorEsperado, retorno);
        }

         [TestMethod]
        public void Teste_ValorVendas_inferior_10000()
        {
            decimal valorVenda = 5000;
            decimal valorEsperado = 250;

            CalculadoraComissao calculadora = new CalculadoraComissao();

            decimal retorno = calculadora.calcular(valorVenda);

            Assert.AreEqual(valorEsperado, retorno);

        }

         [TestMethod]
         public void Teste_ValorVendas_igual_10001_retorno_600_06()
         {
             decimal valorVenda = 10001;
             decimal valorEsperado = 600.06m;

             CalculadoraComissao calculadora = new CalculadoraComissao();

             decimal retorno = calculadora.calcular(valorVenda);

             Assert.AreEqual(valorEsperado, retorno);

         }
        [TestMethod]
         public void Teste_ValorVendas_igual_500_80()
         {
             decimal valorVenda = 500.80m;
             decimal valorEsperado = 25.04m;

             CalculadoraComissao calculadora = new CalculadoraComissao();

             decimal retorno = calculadora.calcular(valorVenda);

             Assert.AreEqual(valorEsperado, retorno);

         }
    }
}
