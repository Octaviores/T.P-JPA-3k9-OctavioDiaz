package org.example;

import entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjemploPersistencia");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Categoria lacteos = Categoria.builder().denominacion("lacteos").build();
            Categoria limpieza = Categoria.builder().denominacion("limpieza").build();

            Articulo articulo1 = Articulo.builder().precio(10).cantidad(20).denominacion("Yougurt LaSerenisima").build();
            Articulo articulo2 = Articulo.builder().precio(10).cantidad(20).denominacion("Esponja DonPepe").build();

            Factura factura1 = Factura.builder().numero(1).fecha("03/03/03").build();

            DetalleFactura det1 = DetalleFactura.builder().cantidad(3).subtotal(3000).articulo(articulo1).build();
            DetalleFactura det2 = DetalleFactura.builder().cantidad(5).subtotal(4000).articulo(articulo1).build();


            Cliente cliente1 = Cliente.builder().nombre("Pablo").apellido("Olbap").dni(12346789).build();
            Domicilio domicilio1 = Domicilio.builder().numero(1).nombreCalle("Bruno").build();



            cliente1.setDomicilio(domicilio1);


            articulo1.getCategorias().add(lacteos);
            articulo2.getCategorias().add(limpieza);

            lacteos.getArticulos().add(articulo1);
            limpieza.getArticulos().add(articulo2);


            factura1.setCliente(cliente1);
            factura1.getDetalle().add(det1);
            factura1.getDetalle().add(det2);

            factura1.setTotal(7000);






            em.persist(factura1);

            em.persist(cliente1);

            em.flush();

            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

        }

        em.close();
        emf.close();
    }
}