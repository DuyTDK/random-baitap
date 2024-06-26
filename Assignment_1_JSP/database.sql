USE [Test]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Content](
	[id] [nvarchar](50) NOT NULL,
	[Title] [nvarchar](50) NOT NULL,
	[Brief] [nvarchar](50) NOT NULL,
	[Content] [nvarchar](150) NOT NULL,
	[CreateDate] [date] NOT NULL,
	[UpdateTime] [date] NOT NULL,
	[Sort] [int] NOT NULL,
	[Authorld] [nvarchar](50) NOT NULL
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Member](
	[id] [nvarchar](50) NOT NULL,
	[Firstname] [nvarchar](50) NOT NULL,
	[Lastname] [nvarchar](50) NOT NULL,
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[Phone] [int] NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[Description] [nvarchar](max) NULL,
	[CreatedDate] [date] NOT NULL,
	[UpdateTime] [date] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
