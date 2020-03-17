USE [BD_REPAS]
GO

/****** Object:  Table [dbo].[aliments]    Script Date: 28/02/2020 13:44:35 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[aliments](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[libelle] [varchar](50) NOT NULL,
	[idRepas] [int] NOT NULL,
 CONSTRAINT [pk_id_alim] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[aliments]  WITH CHECK ADD  CONSTRAINT [fk_alim_repas] FOREIGN KEY([idRepas])
REFERENCES [dbo].[repas] ([id])
GO

ALTER TABLE [dbo].[aliments] CHECK CONSTRAINT [fk_alim_repas]
GO

