package es.santander.justicia.minisJusticia.models.requests.resolverAutorizacion;

import org.simpleframework.xml.Element;

public class ResolverAutorizacionArg0 {
   @Element(
      name = "arg0",
      required = false
   )
   private ResolverAutorizacionArg0Detail resolverAutorizacionArg0Detail;

   public ResolverAutorizacionArg0(ResolverAutorizacionArg0Detail resolverAutorizacionArg0Detail) {
      this.resolverAutorizacionArg0Detail = resolverAutorizacionArg0Detail;
   }
}
