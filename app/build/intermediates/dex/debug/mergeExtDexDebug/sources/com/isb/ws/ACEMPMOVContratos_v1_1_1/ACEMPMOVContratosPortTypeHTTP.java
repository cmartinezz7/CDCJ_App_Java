package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(name = "ACEMPMOVContratosPortTypeHTTP", targetNamespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({ObjectFactory.class})
public interface ACEMPMOVContratosPortTypeHTTP {
    @WebMethod(action = "http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1/listarFiliales_LA", operationName = "listarFiliales_LA")
    @WebResult(name = "listarFiliales_LAResponse", partName = "listarFiliales_LA_OutputPart", targetNamespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1")
    ListarFilialesLAResponse listarFilialesLA(@WebParam(name = "listarFiliales_LA", partName = "listarFiliales_LA_InputPart", targetNamespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1") ListarFilialesLA listarFilialesLA) throws ListarFilialesLAComIsbMoemc2ContratosLaFExcGeneralContratosLAFault, ListarFilialesLAFault;

    @WebMethod(action = "http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1/listarFilialesRepos_LA", operationName = "listarFilialesRepos_LA")
    @WebResult(name = "listarFilialesRepos_LAResponse", partName = "listarFilialesRepos_LA_OutputPart", targetNamespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1")
    ListarFilialesReposLAResponse listarFilialesReposLA(@WebParam(name = "listarFilialesRepos_LA", partName = "listarFilialesRepos_LA_InputPart", targetNamespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1") ListarFilialesReposLA listarFilialesReposLA) throws ListarFilialesReposLAComIsbMoemc2ContratosLaFExcGeneralContratosLAFault, ListarFilialesReposLAFault;

    @WebMethod(action = "http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1/realizarLogon_LA", operationName = "realizarLogon_LA")
    @WebResult(name = "realizarLogon_LAResponse", partName = "realizarLogon_LA_OutputPart", targetNamespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1")
    RealizarLogonLAResponse realizarLogonLA(@WebParam(name = "realizarLogon_LA", partName = "realizarLogon_LA_InputPart", targetNamespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1") RealizarLogonLA realizarLogonLA) throws RealizarLogonLAComIsbMoemc2ContratosLaFExcGeneralContratosLAFault, RealizarLogonLAFault;
}
