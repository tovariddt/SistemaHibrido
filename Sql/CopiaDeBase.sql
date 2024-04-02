PGDMP     "                    {            SistemaSiap    13.3    15.2 2    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    73940    SistemaSiap    DATABASE     y   CREATE DATABASE "SistemaSiap" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.UTF-8';
    DROP DATABASE "SistemaSiap";
                postgres    false                        2615    2200    public    SCHEMA     2   -- *not* creating schema, since initdb creates it
 2   -- *not* dropping schema, since initdb creates it
                postgres    false            �           0    0    SCHEMA public    ACL     Q   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   postgres    false    4            �            1259    73968    Detalle_Insumo    TABLE       CREATE TABLE public."Detalle_Insumo" (
    "ID_Insumo" integer,
    "Fecha_Compra" date NOT NULL,
    "Medida_Insumo" character(30) NOT NULL,
    "Marca_Insumo" character(30) NOT NULL,
    "Fecha_Caducidad" date NOT NULL,
    "Precio_Compra" money NOT NULL
);
 $   DROP TABLE public."Detalle_Insumo";
       public         heap    postgres    false    4            �            1259    73996 	   Ganancias    TABLE     �   CREATE TABLE public."Ganancias" (
    "Fecha_Ganancia" date NOT NULL,
    "ID_Gastos" integer,
    "ID_Venta" integer,
    "ID_Ganancias" integer NOT NULL
);
    DROP TABLE public."Ganancias";
       public         heap    postgres    false    4            �            1259    74143    Ganancias_ID_Ganancias_seq    SEQUENCE     �   CREATE SEQUENCE public."Ganancias_ID_Ganancias_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public."Ganancias_ID_Ganancias_seq";
       public          postgres    false    4    209            �           0    0    Ganancias_ID_Ganancias_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public."Ganancias_ID_Ganancias_seq" OWNED BY public."Ganancias"."ID_Ganancias";
          public          postgres    false    212            �            1259    74020    Gasto_Pagos    TABLE     3  CREATE TABLE public."Gasto_Pagos" (
    "ID_Gastos" integer,
    "Fecha_Pagos" date NOT NULL,
    "Descripción_Pagos" character(250) NOT NULL,
    "Personal_Pagos" character(30) NOT NULL,
    "Monto_Pagos" money NOT NULL,
    "Unidad_Pagos" character(30) NOT NULL,
    "Cantidad_Pagos" integer NOT NULL
);
 !   DROP TABLE public."Gasto_Pagos";
       public         heap    postgres    false    4            �            1259    74012    Gasto_Tarea    TABLE     �   CREATE TABLE public."Gasto_Tarea" (
    "ID_Gastos" integer,
    "Descripción_Tarea" character(250) NOT NULL,
    "Fecha_Tarea" date NOT NULL,
    "Personal_Tarea" character(30) NOT NULL
);
 !   DROP TABLE public."Gasto_Tarea";
       public         heap    postgres    false    4            �            1259    73978    Gastos_General    TABLE       CREATE TABLE public."Gastos_General" (
    "ID_Gastos" integer NOT NULL,
    "Nombre_Gasto" character(30) NOT NULL,
    "Fecha_Gasto" date NOT NULL,
    "Tipo_Gasto" character(30) NOT NULL,
    "Total_Gasto" money NOT NULL,
    "ID_Usuario" integer NOT NULL,
    "ID_Insumo" integer
);
 $   DROP TABLE public."Gastos_General";
       public         heap    postgres    false    4            �            1259    73976    Gastos_Generl_ID_Gastos_seq    SEQUENCE     �   CREATE SEQUENCE public."Gastos_Generl_ID_Gastos_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public."Gastos_Generl_ID_Gastos_seq";
       public          postgres    false    208    4            �           0    0    Gastos_Generl_ID_Gastos_seq    SEQUENCE OWNED BY     b   ALTER SEQUENCE public."Gastos_Generl_ID_Gastos_seq" OWNED BY public."Gastos_General"."ID_Gastos";
          public          postgres    false    207            �            1259    73962    Insumo    TABLE     �   CREATE TABLE public."Insumo" (
    "ID_Insumo" integer NOT NULL,
    "Nombre_Insumo" character(30) NOT NULL,
    "Stock_Insumo" integer NOT NULL,
    "Stock_InsumoMinimo" integer NOT NULL
);
    DROP TABLE public."Insumo";
       public         heap    postgres    false    4            �            1259    73960    Insumo_ID_Insumo_seq    SEQUENCE     �   CREATE SEQUENCE public."Insumo_ID_Insumo_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public."Insumo_ID_Insumo_seq";
       public          postgres    false    4    205            �           0    0    Insumo_ID_Insumo_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public."Insumo_ID_Insumo_seq" OWNED BY public."Insumo"."ID_Insumo";
          public          postgres    false    204            �            1259    73941    Usuario    TABLE     /  CREATE TABLE public."Usuario" (
    "ID_Usuario" integer NOT NULL,
    "Nombre_Usuario" character(30) NOT NULL,
    "ApellidoP_Usuario" character(30) NOT NULL,
    "ApellidoM_Usuario" character(30) NOT NULL,
    "Tipo_Usuario" character(30) NOT NULL,
    "Contraseña_Usuario" character(30) NOT NULL
);
    DROP TABLE public."Usuario";
       public         heap    postgres    false    4            �            1259    73944    Usuario_ID_Usuario_seq    SEQUENCE     �   CREATE SEQUENCE public."Usuario_ID_Usuario_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public."Usuario_ID_Usuario_seq";
       public          postgres    false    200    4            �           0    0    Usuario_ID_Usuario_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public."Usuario_ID_Usuario_seq" OWNED BY public."Usuario"."ID_Usuario";
          public          postgres    false    201            �            1259    73954    Venta    TABLE     #  CREATE TABLE public."Venta" (
    "ID_Venta" integer NOT NULL,
    "Nombre_Venta" character(30) NOT NULL,
    "Fecha_Venta" date NOT NULL,
    "Unidad_Venta" character(30) NOT NULL,
    "Monto_Venta" money NOT NULL,
    "Total_Venta" money NOT NULL,
    "Cantidad_Venta" integer NOT NULL
);
    DROP TABLE public."Venta";
       public         heap    postgres    false    4            �            1259    73952    Venta_ID_Venta_seq    SEQUENCE     �   CREATE SEQUENCE public."Venta_ID_Venta_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public."Venta_ID_Venta_seq";
       public          postgres    false    4    203            �           0    0    Venta_ID_Venta_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public."Venta_ID_Venta_seq" OWNED BY public."Venta"."ID_Venta";
          public          postgres    false    202            O           2604    74145    Ganancias ID_Ganancias    DEFAULT     �   ALTER TABLE ONLY public."Ganancias" ALTER COLUMN "ID_Ganancias" SET DEFAULT nextval('public."Ganancias_ID_Ganancias_seq"'::regclass);
 I   ALTER TABLE public."Ganancias" ALTER COLUMN "ID_Ganancias" DROP DEFAULT;
       public          postgres    false    212    209            �          0    73968    Detalle_Insumo 
   TABLE DATA           �   COPY public."Detalle_Insumo" ("ID_Insumo", "Fecha_Compra", "Medida_Insumo", "Marca_Insumo", "Fecha_Caducidad", "Precio_Compra") FROM stdin;
    public          postgres    false    206   5>       �          0    73996 	   Ganancias 
   TABLE DATA           `   COPY public."Ganancias" ("Fecha_Ganancia", "ID_Gastos", "ID_Venta", "ID_Ganancias") FROM stdin;
    public          postgres    false    209   �>       �          0    74020    Gasto_Pagos 
   TABLE DATA           �   COPY public."Gasto_Pagos" ("ID_Gastos", "Fecha_Pagos", "Descripción_Pagos", "Personal_Pagos", "Monto_Pagos", "Unidad_Pagos", "Cantidad_Pagos") FROM stdin;
    public          postgres    false    211   �>       �          0    74012    Gasto_Tarea 
   TABLE DATA           k   COPY public."Gasto_Tarea" ("ID_Gastos", "Descripción_Tarea", "Fecha_Tarea", "Personal_Tarea") FROM stdin;
    public          postgres    false    210   d?       �          0    73978    Gastos_General 
   TABLE DATA           �   COPY public."Gastos_General" ("ID_Gastos", "Nombre_Gasto", "Fecha_Gasto", "Tipo_Gasto", "Total_Gasto", "ID_Usuario", "ID_Insumo") FROM stdin;
    public          postgres    false    208   �?       �          0    73962    Insumo 
   TABLE DATA           f   COPY public."Insumo" ("ID_Insumo", "Nombre_Insumo", "Stock_Insumo", "Stock_InsumoMinimo") FROM stdin;
    public          postgres    false    205   �@       �          0    73941    Usuario 
   TABLE DATA           �   COPY public."Usuario" ("ID_Usuario", "Nombre_Usuario", "ApellidoP_Usuario", "ApellidoM_Usuario", "Tipo_Usuario", "Contraseña_Usuario") FROM stdin;
    public          postgres    false    200   �@       �          0    73954    Venta 
   TABLE DATA           �   COPY public."Venta" ("ID_Venta", "Nombre_Venta", "Fecha_Venta", "Unidad_Venta", "Monto_Venta", "Total_Venta", "Cantidad_Venta") FROM stdin;
    public          postgres    false    203   2A       �           0    0    Ganancias_ID_Ganancias_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public."Ganancias_ID_Ganancias_seq"', 21, true);
          public          postgres    false    212            �           0    0    Gastos_Generl_ID_Gastos_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public."Gastos_Generl_ID_Gastos_seq"', 1, false);
          public          postgres    false    207            �           0    0    Insumo_ID_Insumo_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public."Insumo_ID_Insumo_seq"', 1, true);
          public          postgres    false    204            �           0    0    Usuario_ID_Usuario_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public."Usuario_ID_Usuario_seq"', 1, false);
          public          postgres    false    201                        0    0    Venta_ID_Venta_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public."Venta_ID_Venta_seq"', 1, false);
          public          postgres    false    202            Y           2606    74150    Ganancias Ganancias_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public."Ganancias"
    ADD CONSTRAINT "Ganancias_pkey" PRIMARY KEY ("ID_Ganancias");
 F   ALTER TABLE ONLY public."Ganancias" DROP CONSTRAINT "Ganancias_pkey";
       public            postgres    false    209            U           2606    73967    Insumo Insumo_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public."Insumo"
    ADD CONSTRAINT "Insumo_pkey" PRIMARY KEY ("ID_Insumo");
 @   ALTER TABLE ONLY public."Insumo" DROP CONSTRAINT "Insumo_pkey";
       public            postgres    false    205            W           2606    73983    Gastos_General Pk-ID_Gastos 
   CONSTRAINT     f   ALTER TABLE ONLY public."Gastos_General"
    ADD CONSTRAINT "Pk-ID_Gastos" PRIMARY KEY ("ID_Gastos");
 I   ALTER TABLE ONLY public."Gastos_General" DROP CONSTRAINT "Pk-ID_Gastos";
       public            postgres    false    208            Q           2606    73951    Usuario Usuario_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public."Usuario"
    ADD CONSTRAINT "Usuario_pkey" PRIMARY KEY ("ID_Usuario");
 B   ALTER TABLE ONLY public."Usuario" DROP CONSTRAINT "Usuario_pkey";
       public            postgres    false    200            S           2606    73959    Venta Venta_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public."Venta"
    ADD CONSTRAINT "Venta_pkey" PRIMARY KEY ("ID_Venta");
 >   ALTER TABLE ONLY public."Venta" DROP CONSTRAINT "Venta_pkey";
       public            postgres    false    203            Z           2606    73971 '   Detalle_Insumo Fk-DetalleInsumos_Insumo    FK CONSTRAINT     �   ALTER TABLE ONLY public."Detalle_Insumo"
    ADD CONSTRAINT "Fk-DetalleInsumos_Insumo" FOREIGN KEY ("ID_Insumo") REFERENCES public."Insumo"("ID_Insumo");
 U   ALTER TABLE ONLY public."Detalle_Insumo" DROP CONSTRAINT "Fk-DetalleInsumos_Insumo";
       public          postgres    false    206    3157    205            ]           2606    74002 &   Ganancias Fk-Ganancias_GastosGenerales    FK CONSTRAINT     �   ALTER TABLE ONLY public."Ganancias"
    ADD CONSTRAINT "Fk-Ganancias_GastosGenerales" FOREIGN KEY ("ID_Gastos") REFERENCES public."Gastos_General"("ID_Gastos");
 T   ALTER TABLE ONLY public."Ganancias" DROP CONSTRAINT "Fk-Ganancias_GastosGenerales";
       public          postgres    false    209    208    3159            ^           2606    74007    Ganancias Fk-Ganancias_Venta    FK CONSTRAINT     �   ALTER TABLE ONLY public."Ganancias"
    ADD CONSTRAINT "Fk-Ganancias_Venta" FOREIGN KEY ("ID_Venta") REFERENCES public."Venta"("ID_Venta");
 J   ALTER TABLE ONLY public."Ganancias" DROP CONSTRAINT "Fk-Ganancias_Venta";
       public          postgres    false    203    209    3155            `           2606    74023 '   Gasto_Pagos Fk-GastoPagos_GastosGeneral    FK CONSTRAINT     �   ALTER TABLE ONLY public."Gasto_Pagos"
    ADD CONSTRAINT "Fk-GastoPagos_GastosGeneral" FOREIGN KEY ("ID_Gastos") REFERENCES public."Gastos_General"("ID_Gastos");
 U   ALTER TABLE ONLY public."Gasto_Pagos" DROP CONSTRAINT "Fk-GastoPagos_GastosGeneral";
       public          postgres    false    3159    208    211            _           2606    74015 &   Gasto_Tarea Fk-GastoTarea_GastoGeneral    FK CONSTRAINT     �   ALTER TABLE ONLY public."Gasto_Tarea"
    ADD CONSTRAINT "Fk-GastoTarea_GastoGeneral" FOREIGN KEY ("ID_Gastos") REFERENCES public."Gastos_General"("ID_Gastos");
 T   ALTER TABLE ONLY public."Gasto_Tarea" DROP CONSTRAINT "Fk-GastoTarea_GastoGeneral";
       public          postgres    false    210    208    3159            [           2606    73984 &   Gastos_General Fk_GastosGeneral_Insumo    FK CONSTRAINT     �   ALTER TABLE ONLY public."Gastos_General"
    ADD CONSTRAINT "Fk_GastosGeneral_Insumo" FOREIGN KEY ("ID_Insumo") REFERENCES public."Insumo"("ID_Insumo") NOT VALID;
 T   ALTER TABLE ONLY public."Gastos_General" DROP CONSTRAINT "Fk_GastosGeneral_Insumo";
       public          postgres    false    208    3157    205            \           2606    73989 '   Gastos_General Fk_GastosGeneral_Usuario    FK CONSTRAINT     �   ALTER TABLE ONLY public."Gastos_General"
    ADD CONSTRAINT "Fk_GastosGeneral_Usuario" FOREIGN KEY ("ID_Usuario") REFERENCES public."Usuario"("ID_Usuario") NOT VALID;
 U   ALTER TABLE ONLY public."Gastos_General" DROP CONSTRAINT "Fk_GastosGeneral_Usuario";
       public          postgres    false    200    208    3153            �   J   x�3�4202�54�50�����W�	8}3�"pJ��k`ʩbh�g`�eH��7�50�T12 ���� ���      �   J   x�]���0�� ��4A鿎 s���iF.�x1��6)�g�AcS �\�$���uw������afzT      �   k   x�3�4202�54�50�NU(JM��IM.I,��S�M���K-V��3 � ��������ob^>U�\���4F�|����*�;|�NǼD|�*�D��W� �@c�      �   f   x�3�NU(J-H,��S(�KT((M-*IT	�����P��H���3 � �J.3P0�d�d�+��(��$&�&g�f�������d�阇/ip��qqq �YM      �   �   x��б
�0���\[r	��+"�]�$`���ŧ7-"$�����������y����ؠl�J�J`�	�
�$\��@�q�J�E���]U#�;�FwtO���v�^��J��b��s7��ɼ�t��vp2�=W���;���vT�      �   (   x�3�N����ITHIU�M���S@����\1z\\\ ��	P      �   g   x�3��,.JL�Q�8]�s3��KS��K��%�Ҭ��ԝY\R�����������f.cNǼD���\T�]�Ҋ̜L\��t�M,������=... ��9j      �   o   x�3�K�+ITHIUp�/.I�Q@�FF���F�ƜX T���p���YF\��Ƨ�0ވ��FSUL��7A�Y����ٙ9��L�ou>��\1z\\\ �,6E     