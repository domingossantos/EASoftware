package br.ufpa.easoft.refact.locadoravideo;

public class Filme {
	public static final int INFANTIL = 2;
	public static final int NORMAL = 0;
	public static final int LANCAMENTO = 1;
	
	private String _titulo;
	private int _codigoPreco;
	
	public Filme (String titulo, int codigoPreco)
	{
		_titulo = titulo;
		_codigoPreco = codigoPreco;
	}
	
	public int getCodigoPreco() 
	{
		return _codigoPreco;	
	}
	
	public void setCodigoPreco(int arg)
	{
		_codigoPreco = arg;
	}
	
	public String getTitulo()
	{
		return _titulo;
	}	
	
	public boolean equals(Object arg0)
	{
		if (arg0 instanceof Filme)
			return	((Filme)arg0).getTitulo().equals(this.getTitulo()) &&
				((Filme)arg0).getCodigoPreco() == this.getCodigoPreco();
		else
			return false;
	}

}
