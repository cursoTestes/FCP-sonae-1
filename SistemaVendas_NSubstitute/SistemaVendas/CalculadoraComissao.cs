using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SistemaVendas
{
    public class CalculadoraComissao
    {

        public decimal calcular(decimal valorVenda)
        {

            if (valorVenda <= 10000)
            {
                return valorVenda * 0.05M;
            }

            else
            {

                return valorVenda * 0.06M;
            }
            
        }
    }
}
