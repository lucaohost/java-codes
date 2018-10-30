package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cadcrianca_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_param_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_escapeXml_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_import_url;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_escapeXml_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_import_url = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_param_value_name_nobody.release();
    _jspx_tagPool_c_out_value_escapeXml_nobody.release();
    _jspx_tagPool_c_import_url.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("           \n");
      out.write("<!-- Verifica as condições de acesso ao sistema -->\n");
      out.write("<!-- include_once './inc/acesso.inc.php'; -->\n");
      out.write("<!-- Cabeçalho da Página -->\n");
      if (_jspx_meth_c_import_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("<!-- Conteúdo da Página -->\n");
      out.write("<div class=\"container\">\n");
      out.write("    <div class=\"panel panel-default\">\n");
      out.write("        <div class=\"panel-heading\">\n");
      out.write("            <h2 class=\"panel-title text-center\">Gestão de Crianças</h2>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"panel-body\">\n");
      out.write("            <!-- Mensagens vindas dos Controllers -->\n");
      out.write("            ");
      if (_jspx_meth_c_out_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            <!-- Formulário que envia dados para o CriancaController -->\n");
      out.write("            <form action=\"CriancaController\" method=\"post\" class=\"form-horizontal\">\n");
      out.write("                <fieldset>\n");
      out.write("                    <input type=\"hidden\" name=\"id\" id=\"id\" value=\"\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"control-label\" for=\"nome\">Nome:</label>  \n");
      out.write("                        <input id=\"nome\" name=\"nome\" type=\"text\" placeholder=\"Digite o nome\" class=\"form-control\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${crianca.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" maxlength=\"100\">\n");
      out.write("                    </div>           \n");
      out.write("                    \n");
      out.write("                    <div class=\"form-row\">\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                          <label class=\"control-label\" for=\"idade\">Idade:</label>  \n");
      out.write("                        <input id=\"idade\" name=\"idade\" type=\"number\" min=\"0\" max=\"10\" placeholder=\"Digite a idade\" class=\"form-control\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${crianca.idade}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"sexo\">Sexo:</label>\n");
      out.write("                                <div class=\"col-md-6\"> \n");
      out.write("                                    <label class=\"radio-inline\" for=\"masculino\">\n");
      out.write("                                        <input type=\"hidden\" name=\"sexoSetado\" id=\"sexoSetado\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${crianca.sexo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" >\n");
      out.write("                                        <input type=\"radio\" name=\"sexo\" id=\"masculino\" required=\"\" value=\"M\" >\n");
      out.write("                                        Masculino\n");
      out.write("                                    </label> \n");
      out.write("                                    <label class=\"radio-inline\" for=\"feminino\">\n");
      out.write("                                        <input type=\"radio\" name=\"sexo\" id=\"feminino\" required=\"\" value=\"F\" >\n");
      out.write("                                        Feminino\n");
      out.write("                                    </label>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-row\">\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("\n");
      out.write("                            <label class=\"control-label\" for=\"etnia\">Cor/Etnia:</label>\n");
      out.write("                            <select id=\"etnia\" name=\"etnia\" class=\"form-control\">\n");
      out.write("                              <option value=\"B\" >Branca</option>\n");
      out.write("                              <option value=\"N\" >Negra</option>\n");
      out.write("                              <option value=\"P\" >Parda</option>\n");
      out.write("                              <option value=\"I\" >Indígena</option>\n");
      out.write("                              <option value=\"A\" >Amarela</option>\n");
      out.write("                            </select>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label class=\"control-label\" for=\"parto\">Parto:</label>\n");
      out.write("                            <div class=\"checkbox\">\n");
      out.write("                                <label for=\"parto_natural\">                                    \n");
      out.write("                                  <input type=\"checkbox\" name=\"parto\" id=\"parto_natural\"  >\n");
      out.write("                                  Natural\n");
      out.write("                                </label>\n");
      out.write("                            </div>    \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"control-label\" for=\"mae\">Nome da Mãe:</label>  \n");
      out.write("                        <input id=\"mae\" name=\"mae\" type=\"text\" placeholder=\"Digite o nome da mãe\" class=\"form-control\" required=\"\" value=\"\" maxlength=\"100\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-row\">\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label class=\"control-label\" for=\"email\">E-mail:</label>  \n");
      out.write("                            <input id=\"email\" name=\"email\" type=\"email\" aria-describedby=\"emailHelp\"  placeholder=\"Digite o e-mail\" class=\"form-control\" required=\"\" value=\"\" maxlength=\"100\">\n");
      out.write("                            <small id=\"emailHelp\" class=\"form-text text-muted\">Ex: email@gmail.com</small>\n");
      out.write("                        </div>\n");
      out.write("                    \n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label class=\"control-label\" for=\"telefone\">Telefone:</label>  \n");
      out.write("                            <input id=\"telefone\" name=\"telefone\" type=\"text\" aria-describedby=\"telHelp\"  placeholder=\"Digite o e-mail\" class=\"form-control\" required=\"\" value=\"\" maxlength=\"20\">\n");
      out.write("                            <small id=\"telHelp\" class=\"form-text text-muted\">Ex: (54)9876-5432</small>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-row\">\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label class=\"control-label\" for=\"salvar\"></label>\n");
      out.write("                            <button id=\"salvar\" name=\"salvar\" class=\"btn btn-primary btn-lg btn-block\">Salvar</button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label class=\"control-label\" for=\"cancelar\"></label>\n");
      out.write("                            <button id=\"cancelar\" name=\"cancelar\" class=\"btn btn-secondary btn-lg btn-block\" onclick=\"window.location.href='listcrianca.jsp'\" type=\"button\">Cancelar</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>                    \n");
      out.write("                </fieldset>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<script>\n");
      out.write("    if(document.getElementById(\"sexoSetado\").value == \"M\"){\n");
      out.write("        document.getElementById(\"masculino\").checked = true;\n");
      out.write("    }\n");
      out.write("    if(document.getElementById(\"sexoSetado\").value == \"F\"){\n");
      out.write("        document.getElementById(\"feminino\").checked = true;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("</script>\n");
      out.write("<!-- Rodapé da Página -->\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "inc/rodape.inc.jsp", out, false);
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_import_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_url.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_0.setPageContext(_jspx_page_context);
    _jspx_th_c_import_0.setParent(null);
    _jspx_th_c_import_0.setUrl("inc/cabecalho.inc.jsp");
    int[] _jspx_push_body_count_c_import_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_0 = _jspx_th_c_import_0.doStartTag();
      if (_jspx_eval_c_import_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_c_import_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_c_import_0[0]++;
          _jspx_th_c_import_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_c_import_0.doInitBody();
        }
        do {
          out.write("\n");
          out.write("    ");
          if (_jspx_meth_c_param_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_import_0, _jspx_page_context, _jspx_push_body_count_c_import_0))
            return true;
          out.write('\n');
          int evalDoAfterBody = _jspx_th_c_import_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_c_import_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_c_import_0[0]--;
      }
      if (_jspx_th_c_import_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_0.doFinally();
      _jspx_tagPool_c_import_url.reuse(_jspx_th_c_import_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_param_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_import_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_import_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_0 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_0.setPageContext(_jspx_page_context);
    _jspx_th_c_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_import_0);
    _jspx_th_c_param_0.setName("pageName");
    _jspx_th_c_param_0.setValue("Cadastro");
    int _jspx_eval_c_param_0 = _jspx_th_c_param_0.doStartTag();
    if (_jspx_th_c_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_0);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_0);
    return false;
  }

  private boolean _jspx_meth_c_out_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_escapeXml_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent(null);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensagem}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_out_0.setEscapeXml(false);
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_escapeXml_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_escapeXml_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }
}
